public class Color {
  public String colorText(String colorIndex, String text) {
    // ANSI codes
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_CYAN = "\u001B[36m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";

    String color = switch (colorIndex.toLowerCase()) {
      case "red" -> ANSI_RED;
      case "yellow" -> ANSI_YELLOW;
      case "purple" -> ANSI_PURPLE;
      case "blue" -> ANSI_BLUE;
      case "green" -> ANSI_GREEN;
      case "cyan" -> ANSI_CYAN;
      default -> ANSI_RESET;
    };

    return color + text + ANSI_RESET;
  }
}
