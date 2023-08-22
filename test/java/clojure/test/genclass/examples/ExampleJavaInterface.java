package clojure.test.genclass.examples;

public interface ExampleJavaInterface {

    String notDefaultName();

    default String defaultName() {
        return "name-from-interface-1";
    }

    default String implementedDefaultName() {
        return "name-from-interface-2";
    }

    String notImplementedNotDefaultName();
}
