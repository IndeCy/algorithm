package SingletonMode;


public class SingletonModel {

    private SingletonModel(){}

    private static class Holder{
        private static final SingletonModel singletonModel = new SingletonModel();
    }

    public static SingletonModel getInstance(){
        return Holder.singletonModel;
    }

}
