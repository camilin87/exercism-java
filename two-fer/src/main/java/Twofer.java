class Twofer {
    public String twofer(String name) {
        String sanitizedName = sanitize(name);
        return String.format("One for %s, one for me.", sanitizedName);
    }

    private String sanitize(String name){
        if (name == null){
            return "you";
        }

        return name;
    }
}
