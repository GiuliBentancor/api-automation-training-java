package models.requests;

public class CatModel {

    private Integer id;
    private String firstname;
    private Integer age;
    private String breed;
    private String dateJoined;
    private Boolean vaccinated;
    private String temperament;
    private String staffInCharge;
    private boolean isAdopted;
    private Integer adopterId;

    public CatModel() {
    }

    public static class BookingDates {
        private String checkin;
        private String checkout;

        public String getCheckin() {
            return checkin;
        }

        public void setCheckin(String checkin) {
            this.checkin = checkin;
        }

        public String getCheckout() {
            return checkout;
        }

        public void setCheckout(String checkout) {
            this.checkout = checkout;
        }
    }

}