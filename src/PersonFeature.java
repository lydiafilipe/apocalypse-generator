public class PersonFeature
{
    enum FeatureType {
        ADJ_PRE, ADJ_SUF
    }

    String feature;
    FeatureType type;

    public PersonFeature(String feature, FeatureType type)
    {
        this.feature = feature;
        this.type = type;
    }

}
