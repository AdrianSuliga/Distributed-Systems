package model;

import generated.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class CameraBase extends DeviceBase {
    protected CameraType cameraType;
    protected PTZ currentPTZ;

    protected LocalDateTime startTime;

    public CameraBase(int id, String name, CameraType cameraType) {
        super(id, name, DeviceType.CAMERA);
        this.cameraType = cameraType;
        this.currentPTZ = new PTZ(0, 90, 1);
    }

    public CameraType getCameraType() {
        return this.cameraType;
    }

    public void setPTZ(int pan, int tilt, int zoom) throws Exception {
        PTZ point = new PTZ(pan, tilt, zoom);
        if (isPTZInvalid(point)) {
            throw new Exception("Wrong PTZ values");
        }

        System.out.println("Setting PTZ for " + this.name);

        this.currentPTZ = new PTZ(pan, tilt, zoom);
    }

    public ImageInfo captureImage(ImgFormat format) {
        System.out.println("Capturing image on " + this.name);

        return new ImageInfo(
                "company.com/photos?i=" + UUID.randomUUID() + "." + format.toString(),
                400,
                300,
                ThreadLocalRandom.current().nextInt(200, 401));
    }

    public List<ImageInfo> captureImages(List<ImgFormat> formats) {
        System.out.println("Capturing " + formats.size() + " images on " + this.name);

        List<ImageInfo> result = new ArrayList<>();

        for (ImgFormat format : formats) {
            result.add(captureImage(format));
        }

        return result;
    }

    public void startRecording() {
        System.out.println("Starting recording on " + this.name);

        this.startTime = LocalDateTime.now();
    }

    public RecordingInfo stopRecording() throws Exception {
        if (this.startTime == null) {
            throw new Exception("Recording not in progress");
        }

        System.out.println("Recording finished on " + this.name);

        int elapsedTime = (int)Duration.between(this.startTime, LocalDateTime.now()).getSeconds();
        int size = 1011 * elapsedTime; // in kB

        RecordingInfo result = new RecordingInfo(
                "company.com/videos?v=" + UUID.randomUUID(),
                elapsedTime,
                size
        );

        this.startTime = null;

        return result;
    }

    public void setPatrolRoute(List<PatrolPointInfo> patrolPoints, List<LocalTime> activeHours) throws Exception {
        System.out.println("Setting patrol route for " + this.name);

        for (PatrolPointInfo point : patrolPoints) {
            if (isPTZInvalid(point.point())) {
                throw new Exception("Invalid PTZ value " + point);
            }

            System.out.println("Patrol point = " + point);
        }

        System.out.println("Selected patrol route will be enabled on: [");

        for (LocalTime time : activeHours) {
            System.out.println(time + ",");
        }

        System.out.println("]");
    }

    private boolean isPTZInvalid(PTZ point) {
        return (point.pan() < 0 || point.pan() > 360) ||
                (point.tilt() < 0 || point.tilt() > 180) ||
                (point.zoom() < 1 || point.zoom() > 30);
    }
}
