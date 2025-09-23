class PetService {
    public double calculateFee() {
        return 50.0;
    }
    public double calculateFee(boolean withVaccination) {
        return 75.0;
    }
    public double calculateFee(boolean withVaccination, boolean withGrooming) {
        return 105.0;
    }
    public double calculateFee(String emergency) {
        return 200.0;
    }
}
