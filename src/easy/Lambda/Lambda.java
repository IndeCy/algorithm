package easy.Lambda;

public class Lambda {

    public boolean checkPwd(String pwd,CheckPwd checkPwd){
        return checkPwd.apply(pwd);
    }
}
