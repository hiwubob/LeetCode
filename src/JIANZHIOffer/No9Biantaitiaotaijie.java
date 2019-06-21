package JIANZHIOffer;

public class No9Biantaitiaotaijie {
    public int JumpFloorII(int target) {
        if (target <= 1) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
}
