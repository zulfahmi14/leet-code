class Solution {
public:
    string numberToWords(int num) {
        if (num == 0) return "Zero";

        string numStr = to_string(num);
        int len = numStr.length();
        reverse(numStr.begin(), numStr.end());
        string ans = "";
        for(int i = 0 ; i < len ; i+=3) {
            string tempAns = "";
            if (i+1 < len && numStr[i+1] == '1') {
                cout << "tens";
                tempAns = teensNum(numStr[i]) + tempAns;
            } else if (i+1 < len && numStr[i+1] != '1') {
                cout << "teens";
                tempAns = singleNum(numStr[i]) + tempAns;
                tempAns = tensNum(numStr[i+1]) + tempAns;
            } else {
                cout << "single";
                tempAns = singleNum(numStr[i]) + tempAns;
            }

            if (i+2 < len && numStr[i+2] != '0') {
                tempAns = singleNum(numStr[i+2]) + " Hundred" + tempAns;
            }

            if (!allZero(numStr, len, i)) {
                tempAns += levelNum(i/3);
            }

            ans = tempAns + ans;
        }

        return ans.erase(0, 1);
    }

    bool allZero(string a, int len, int i) {
        if (a[i] != '0') return false ;
        if (i+1 < len && a[i+1] != '0') return false ;
        if (i+2 < len && a[i+2] != '0') return false ;

        return true ;
    }

    string singleNum(char c) {
        switch(c) {
            case '1': return " One";
            case '2': return " Two";
            case '3': return " Three";
            case '4': return " Four";
            case '5': return " Five";
            case '6': return " Six";
            case '7': return " Seven";
            case '8': return " Eight";
            case '9': return " Nine"; 
            default : return "";
        }
    }

    string teensNum(char c) {
        switch(c) {
            case '1': return " Eleven";
            case '2': return " Twelve";
            case '3': return " Thirteen";
            case '4': return " Fourteen";
            case '5': return " Fifteen";
            case '6': return " Sixteen";
            case '7': return " Seventeen";
            case '8': return " Eighteen";
            case '9': return " Nineteen"; 
            default : return " Ten";
        }
    }

    string tensNum(char c) {
        switch(c) {
            case '2': return " Twenty";
            case '3': return " Thirty";
            case '4': return " Forty";
            case '5': return " Fifty";
            case '6': return " Sixty";
            case '7': return " Seventy";
            case '8': return " Eighty";
            case '9': return " Ninety"; 
            default : return "";
        }
    }

    string levelNum(int i) {
        switch(i) {
            case 1: return " Thousand";
            case 2: return " Million";
            case 3: return " Billion";
            default : return "";
        }
    }
};