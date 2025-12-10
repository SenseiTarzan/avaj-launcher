package avaj.launcher.Class;

public final class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void addLongitude(int longitude) {
        this.longitude += longitude;
    }

    public void subtractLongitude(int longitude) {
        this.longitude -= longitude;
    }

    public void addLatitude(int latitude) {
        this.latitude += latitude;
    }
    public void subtractLatitude(int latitude) {
        this.latitude -= latitude;
    }

    public void addHeight(int height) {
        this.height += height;
        if (this.height > 100) {
            this.height = 100;
        } else if (this.height < 0) {
            this.height = 0;
        }
    }

    public void subtractHeight(int height) {
        this.height -= height;
        if (this.height < 0)
            this.height = 0;
    }

    public boolean isOnGround() {
        return this.height <= 0;
    }
}