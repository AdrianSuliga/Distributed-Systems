from fastapi import FastAPI, status
from fastapi.responses import JSONResponse
from typing import List, Tuple

class Option:
    def __init__(self, message: str, count: int):
        self.message = message
        self.count = count

    def set_message(self, new_message: str):
        self.message = new_message

    def get_message(self):
        return self.message
    
    def set_count(self, new_count: int):
        self.count = new_count
    
    def get_count(self):
        return self.count
    
    def to_dict(self):
        return {
            "message": self.message,
            "votes": self.count
        }

class Poll:
    def __init__(self):
        self.options = []

    def add_option(self, new_option: str):
        self.options.append(Option(new_option, 0))

    def remove_option(self, message: str):
        idx = -1

        for i, option in enumerate(self.options):
            if option.get_message() == message:
                idx = i
                break

        if idx > -1:
            self.options.pop(idx)

    def to_dict(self):
        return {
            "options": self.options
        }

app = FastAPI()
poll = None

@app.get("/poll/view")
async def view_poll():
    global poll
    if poll is None:
        return JSONResponse(status_code=status.HTTP_404_NOT_FOUND, content="No poll is being held")
    return poll.to_dict()

@app.post("/poll/create")
async def create_poll(data: List[str]):
    global poll
    poll = Poll()
    for msg in data:
        if len(msg) > 0:
            poll.add_option(msg)
    return poll.to_dict()

@app.put("/poll/vote")
async def cast_vote(data: str):
    global poll
    for option in poll.options:
        if option.get_message() == data:
            option.set_count(option.get_count() + 1)
            return JSONResponse(status_code=status.HTTP_202_ACCEPTED, content="Changed")

    return JSONResponse(status_code=status.HTTP_404_NOT_FOUND, content="Option not found")

@app.put("/poll/unvote")
async def remove_vote(data: str):
    global poll
    for option in poll.options:
        if option.get_message() == data:
            current_count = option.get_count()

            if current_count == 0:
                return JSONResponse(status_code=status.HTTP_403_FORBIDDEN, content="Cannot have less than 0 votes") 
            else: 
                option.set_count(current_count - 1)
                return JSONResponse(status_code=status.HTTP_202_ACCEPTED, content="Changed")
    
    return JSONResponse(status_code=status.HTTP_404_NOT_FOUND, content="Option not found")

@app.put("/poll/edit")
async def edit_poll(data: Tuple[List[str], List[str]]):
    global poll

    to_add, to_delete = data

    for new_option in to_add:
        poll.add_option(new_option)

    for old_option in to_delete:
        poll.remove_option(old_option)

    return poll.to_dict()

@app.delete("/poll/delete")
async def delete_poll():
    global poll
    poll = None
    return JSONResponse(status_code=status.HTTP_200_OK, content="Deleted poll")
