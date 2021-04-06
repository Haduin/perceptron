package pl.chodan;

public class Classification {

    private String irisType;
    private boolean match;

    public Classification(String irisType, boolean match) {
        this.irisType = irisType;
        this.match = match;
    }

    public String getIrisType() {
        return irisType;
    }

    public void setIrisType(String irisType) {
        this.irisType = irisType;
    }

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "irisType='" + irisType + '\'' +
                ", match=" + match +
                '}';
    }
}
