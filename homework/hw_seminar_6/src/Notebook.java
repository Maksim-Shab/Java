public class Notebook {
    String serialNumber; //unique
    int screenSizeInch;
    int ramSizeGb;
    int diskSizeGb; //hdd, ssd
    String os;
    String color;

    Notebook(String serialNumber, int screenSizeInch, int ramSizeGb, int diskSizeGb, String os, String color) {
        this.serialNumber = serialNumber;
        this.screenSizeInch = screenSizeInch;
        this.ramSizeGb = ramSizeGb;
        this.diskSizeGb = diskSizeGb;
        this.os = os;
        this.color = color;
    }

    String getSerialNumber() {
        return serialNumber;
    }

    int getScreenSizeInch() {
        return screenSizeInch;
    }

    int getRamSizeGb() {
        return ramSizeGb;
    }

    int getDiskSizeGb() {
        return diskSizeGb;
    }

    String getOs() {
        return os;
    }

    String getColor() {
        return color;
    }
}