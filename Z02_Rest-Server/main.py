from fastapi import FastAPI, status
from fastapi.responses import HTMLResponse
from random import randint
import httpx

# API keyw
def read_key(path):
    with open(path) as f:
        return f.read()

DOG_API_KEY_PATH = "dog_api_key.txt"
DOG_API_KEY = read_key(DOG_API_KEY_PATH)

DOG_NINJA_API_KEY_PATH = "ninja_api_key.txt"
DOG_NINJA_API_KEY = read_key(DOG_NINJA_API_KEY_PATH)

# index.html path
INDEX_PATH = "index.html"

# result.html path and strings for replacement
RES_PATH = "response.html"
RES_REPLACE_STR = "$CONTENT$"

# error.html path and strings for replacement
ERR_PATH = "error.html"
ERR_IMG_STR = "$ERR_IMG_SRC$"
ERR_IMG_ALT = "$ALT_IMG_STR$"
ERR_MSG_STR = "$ERR_MSG_STR$"

# API URLs
DOG_ERRORS_GENERIC = "https://http.dog"
DOG_FACTS_GENERIC = "https://dogapi.dog/api/v2/facts"
DOG_API_GENERIC = "https://api.thedogapi.com/v1"
DOG_NINJA_API_GENERIC = "https://api.api-ninjas.com/v1/dogs"

# App object
app = FastAPI()

# Return error.html with error specific content
def return_error(http_code: int, error_msg: int):
    html_content = ""

    with open(ERR_PATH, "r") as f:
        html_content = f.read()

    html_content = html_content.replace(ERR_IMG_STR, f"\"{DOG_ERRORS_GENERIC}/{http_code}.jpg\"")
    html_content = html_content.replace(ERR_IMG_ALT, f"\"HTTP {http_code} as dog image.\"")
    html_content = html_content.replace(ERR_MSG_STR, error_msg)

    return HTMLResponse(content = html_content, status_code = http_code)

# Static form
@app.get("/")
async def start_index():
    html_content = ""
    
    with open(INDEX_PATH, "r") as f:
        html_content = f.read()
    
    return HTMLResponse(content = html_content, status_code = status.HTTP_200_OK)

# Generate response based on multiple APIs
@app.get("/generate")
async def start_response(mode: str, count: int = 1, breed_name: str = "", 
                        images_count: int = 0, fun_facts_count: int = 0,
                        get_statistics: bool = False):
    RES_STR = ""

    ninja_headers = {
        "X-Api-Key": DOG_NINJA_API_KEY
    }

    dog_headers = {
        "x-api-key": DOG_API_KEY
    }

    breed_source, images, statistics = [], [], []

    # Get count number of breeds information
    if mode == "many":        
        async with httpx.AsyncClient() as client:
            response = await client.get(f"{DOG_API_GENERIC}/breeds", headers=dog_headers, params={"limit": count})

        breed_source = response.json()
        
    # Draw random breed
    elif mode == "random":
        async with httpx.AsyncClient() as client:
            response = await client.get(f"{DOG_API_GENERIC}/breeds", headers=dog_headers, params={})

        random_breed = response.json()[randint(0, len(response.json()))]

        breed_source = [random_breed]
        
    # Search for specific breed
    elif mode == "breed":
        async with httpx.AsyncClient() as client:
            response = await client.get(f"{DOG_API_GENERIC}/breeds/search", headers=dog_headers, params={"q": breed_name, "limit": 5})

        breed_source = response.json()

    # Some error
    else:
        return return_error(400, f"Chosen unknown search option: {mode}")

    # Extract only relevant breed information
    breeds = [(breed.get("id"), breed.get("name"), breed.get("life_span"),
                   breed.get("temperament"), breed.get("origin"),
                   breed.get("description"), breed.get("history"),
                   breed.get("image").get("url")) for breed in breed_source]
    
    if len(breeds) == 0:
        return return_error(404, "Couldn't find any dogs matching your criteria")

    # Get up to images_count number of images of each breed
    if images_count > 0:
        for breed in breeds:
            id = breed[0]

            async with httpx.AsyncClient() as client:
                response = await client.get(f"{DOG_API_GENERIC}/images/search", headers=dog_headers, params={"limit": images_count,
                                                                                                             "breed_id": id})
                
            res_list = list(response.json())

            images.append([image.get("url") for image in res_list])

    # Get statistics about each breed
    if get_statistics:
        for breed in breeds:
            name = breed[1]
            
            async with httpx.AsyncClient() as client:
                response = await client.get(DOG_NINJA_API_GENERIC, headers=ninja_headers, params={"name": name})
            
            res_list = list(response.json())

            # If no stats for given breed than silently ignore
            if res_list == []:
                statistics.append(())
            else:
                res_dict = res_list[0]
                statistics.append((res_dict.get("good_with_children"), res_dict.get("good_with_other_dogs"),
                                   res_dict.get("good_with_strangers"), res_dict.get("shedding"), res_dict.get("grooming"),
                                   res_dict.get("drooling"), res_dict.get("coat_length"), res_dict.get("playfulness"),
                                   res_dict.get("protectiveness"), res_dict.get("trainability"), res_dict.get("energy"),
                                   res_dict.get("barking"), res_dict.get("min_height_male"), res_dict.get("max_height_male"),
                                   res_dict.get("min_weight_male"), res_dict.get("max_weight_male"),
                                   res_dict.get("min_height_female"), res_dict.get("max_height_female"),
                                   res_dict.get("min_weight_female"), res_dict.get("max_weight_female")))

    # Generate HTML content
    for i, breed in enumerate(breeds):
        id, breed_name, life_span, temperament, origin, desciption, history, image_url = breed
        temperament = temperament.replace(", ", " | ").lower()

        RES_STR += (
            f'<div class="breed-card">'
                f'<h2>{i + 1}. {breed_name}</h2>'
                f'<h3 class="breed-meta">Life span {life_span} years | Originating in {origin} | {temperament}</h3>'
                f'<div class="breed-content">'
                    f'<img src="{image_url}">'
                    f'<div class="breed-text">'
                        f'<p>{desciption}</p>'
                        f'<p>{history}</p>'
                    f'</div>'
                f'</div>'
        )

        if images_count > 0:
            if len(images[i]) == 0:
                RES_STR += f'<p>Failed to fetch images of {breed[1]}</p>'

            for img in images[i]:
                RES_STR += f'<img src="{img}" width=350px height=250px>'

        if get_statistics:
            if len(statistics[i]) == 0:
                RES_STR += f'<p>Failed to fetch statistics for {breed[1]}</p>'
            else:
                good_with_children, good_with_other_dogs, \
                good_with_strangers, shedding, grooming, \
                drooling, coat_length, playfulness, \
                protectiveness, trainability, energy, \
                barking, min_height_male, max_height_male, \
                min_weight_male, max_weight_male, \
                min_height_female, max_height_female, \
                min_weight_female, max_weight_female = statistics[i]

                RES_STR += (
                    f'<div style="display:flex; gap:40px;">'
                        f'<div>'
                            f'<h4>Male</h4>'
                            f'<p>Weight {min_weight_male} - {max_weight_male} kg</p>'
                            f'<p>Height {min_height_male} - {max_height_male} cm</p>'
                        f'</div>'
                        f'<div>'
                            f'<h4>Female</h4>'
                            f'<p>Weight {min_weight_female} - {max_weight_female} kg</p>'
                            f'<p>Height {min_height_female} - {max_height_female} cm</p>'
                        f'</div>'
                )

                stats = [
                    ("Good with children", good_with_children),
                    ("Good with dogs", good_with_other_dogs),
                    ("Good with strangers", good_with_strangers),
                    ("Shedding", shedding),
                    ("Grooming", grooming),
                    ("Drooling", drooling),
                    ("Playfulness", playfulness),
                    ("Protectiveness", protectiveness),
                    ("Trainability", trainability),
                    ("Energy", energy),
                    ("Barking", barking),
                    ("Coat Length", coat_length)
                ]

                for i in range(0, len(stats), 2):
                    RES_STR += f'<div class="stat-row">'

                    for j in range(2):
                        name, value = stats[i + j]
                        percent = (value / 5) * 100
                        RES_STR += (
                                f'<div class="stat-label">{name} ({value}/5)</div>'
                                f'<div class="stat-bar">'
                                    f'<div class="stat-fill" style="width:{percent}%"></div>'
                                f'</div>'
                        )

                    RES_STR += f'</div>'

                RES_STR += f'</div>'

        RES_STR += f'</div>'

    # Add random, generic fun facts
    if fun_facts_count > 0:
        fact_data: list = []
        
        async with httpx.AsyncClient() as client:
            response = await client.get(f"{DOG_FACTS_GENERIC}?limit={fun_facts_count}")
        
        fact_data = [d["attributes"]["body"] for d in response.json()["data"]]

        # If failed to retrieve enough information
        if (len(fact_data) != fun_facts_count):
            return return_error(400, f"Couldn't retrieve {fun_facts_count} fun facts. Number too high.")
        
        RES_STR += f'<div class="facts-box"><h1>Did you know?</h1>'

        for i in range(1, fun_facts_count + 1):
            RES_STR += f"<p>{fact_data[i - 1]}</p>"

        RES_STR += "</div>"

    # Put generated string into html response
    html_content = ""

    with open(RES_PATH, "r") as f:
        html_content = f.read()

    html_content = html_content.replace(RES_REPLACE_STR, RES_STR)

    return HTMLResponse(content = html_content, status_code = status.HTTP_200_OK)
