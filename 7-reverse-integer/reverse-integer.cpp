class Solution {
public:
    long long reverse(int x) {
        string s = to_string(x);
        ::reverse(s.begin(), s.end());

        long long ans = stoll(s);
        if(ans > INT_MAX) return 0;
        return x>=0? stoll(s) : stoll(s)*-1;
    }
};

// 123 -> x%10 -> 3
// 