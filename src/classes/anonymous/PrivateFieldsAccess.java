package classes.anonymous;

/**
 * Created by Yahor_Karabitsyn on 2/10/2015.
 */
public class PrivateFieldsAccess {

    public String classString1;

    // "static java.lang.String access$000(classes.anonymous.PrivateFieldsAccess)" method is created
    private String classString2;

    private PrivateFieldsAccess() {
    }

    private void privateMethod() {
        new InnerClass();
    }

    public void testCreateInnerClass(PrivateFieldsAccess outer) {
        outer.new InnerClass();
    }

    // this method conflict for compile-generated one
    /*String access$000(PrivateFieldsAccess object) {
        return object.classString2;
    }*/

    private class InnerClass {
        private PrivateFieldsAccess this$0;

        private String innerClassString;

        public void accessOuterClass() {
            PrivateFieldsAccess object = new PrivateFieldsAccess();
            object.privateMethod();

            System.out.println(classString1);

            // invokestatic Method classes/anonymous/PrivateFieldsAccess.access$000:(Lclasses/anonymous/PrivateFieldsAccess;)Ljava/lang/String;
            System.out.println(classString2);
        }

    }

}
