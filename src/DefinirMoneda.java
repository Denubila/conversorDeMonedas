public class DefinirMoneda {
    public String getMoneda(int choice){
        return switch (choice) {
            case 1 -> "USD";
            case 2 -> "COP";
            case 3 -> "ARS";
            case 4 -> "BRL";
            case 5 -> "MXN";
            case 6 -> "CLP";
            default -> "";
        };
    }
}
