package mariuszjaczewski.repository_rest.api;

public class SearchingDetails {


    private String title;

    private Long category;

    private float priceDown;

    private float priceUp;

    private boolean ifNew;

    private boolean ifSecondHand;


    @Override
    public String toString() {
        return "SearchingDetails{" +
                "title='" + title + '\'' +
                ", category=" + category +
                ", priceDown=" + priceDown +
                ", priceUp=" + priceUp +
                ", ifNew=" + ifNew +
                ", ifSecondHand=" + ifSecondHand +
                '}';
    }

    public SearchingDetails(String title, Long category, float priceDown, float priceUp, boolean ifNew, boolean ifSecondHand) {
        this.title = title;
        this.category = category;
        this.priceDown = priceDown;
        this.priceUp = priceUp;
        this.ifNew = ifNew;
        this.ifSecondHand = ifSecondHand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public float getPriceDown() {
        return priceDown;
    }

    public void setPriceDown(float priceDown) {
        this.priceDown = priceDown;
    }

    public float getPriceUp() {
        return priceUp;
    }

    public void setPriceUp(float priceUp) {
        this.priceUp = priceUp;
    }

    public boolean isIfNew() {
        return ifNew;
    }

    public void setIfNew(boolean ifNew) {
        this.ifNew = ifNew;
    }

    public boolean isIfSecondHand() {
        return ifSecondHand;
    }

    public void setIfSecondHand(boolean ifSecondHand) {
        this.ifSecondHand = ifSecondHand;
    }
}
