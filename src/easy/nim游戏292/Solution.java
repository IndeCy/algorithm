package easy.nim游戏292;

public class Solution {

    /**
     * 我只有给对面留4的倍数我才必胜 相反对面给我留4的倍数我必败 所以考虑我是先手 只要原来是4的倍数我就输了
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
