package lang.features.interfaceinheritance;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeatureInterfaceExtends implements IT2 {
    public static void main(String[] args) {
        FeatureInterfaceExtends featureInterfaceExtends = new FeatureInterfaceExtends();
        featureInterfaceExtends.test();
    }
}
