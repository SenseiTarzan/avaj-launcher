package avaj.launcher.Class;

public final class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        if (p_longitude < 0) {
            throw new IllegalArgumentException("Longitude must be positive: " + p_longitude);
        }
        if (p_latitude < 0) {
            throw new IllegalArgumentException("Latitude must be positive: " + p_latitude);
        }
        if (p_height < 0 || p_height > 100) {
            throw new IllegalArgumentException("Height must be between 0 and 100: " + p_height);
        }
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
        if (this.longitude < 0) {
            this.longitude = 0;
        }
    }

    public void subtractLongitude(int longitude) {
        this.longitude -= longitude;
        if (this.longitude < 0) {
            this.longitude = 0;
        }
    }

    public void addLatitude(int latitude) {
        this.latitude += latitude;
        if (this.latitude < 0) {
            this.latitude = 0;
        }
    }
    public void subtractLatitude(int latitude) {
        this.latitude -= latitude;
        if (this.latitude < 0) {
            this.latitude = 0;
        }
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