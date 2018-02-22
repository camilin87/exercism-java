class SpaceAge {

    private final double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return this.seconds;
    }

    double onEarth() {
        return ageOnPlanetWithOrbitalPeriod(1.0);
    }

    double onMercury() {
        return ageOnPlanetWithOrbitalPeriod(0.2408467);
    }

    double onVenus() {
        return ageOnPlanetWithOrbitalPeriod(0.61519726);
    }

    double onMars() {
        return ageOnPlanetWithOrbitalPeriod(1.8808158);
    }

    double onJupiter() {
        return ageOnPlanetWithOrbitalPeriod(11.862615);
    }

    double onSaturn() {
        return ageOnPlanetWithOrbitalPeriod(29.447498);
    }

    double onUranus() {
        return ageOnPlanetWithOrbitalPeriod(84.016846);
    }

    double onNeptune() {
        return ageOnPlanetWithOrbitalPeriod(164.79132);
    }

    private double ageOnPlanetWithOrbitalPeriod(double earthsOrbitalPeriodFraction){
        return getSeconds() / earthYearInSeconds(earthsOrbitalPeriodFraction);
    }

    private double earthYearInSeconds(double factor){
        return factor * 365.25 * 24 * 60 * 60;
    }

}
