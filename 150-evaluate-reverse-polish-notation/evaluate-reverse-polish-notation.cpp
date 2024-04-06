class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> numb;
        int total ;
        for (int i = 0 ; i < tokens.size() ; i++) {
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
                int a = numb.top(); numb.pop();
                int b = numb.top(); numb.pop();
                numb.push(calculate(a, b, tokens[i]));
            } else {
                numb.push(stoi(tokens[i]));
            }
        }

        return numb.top();
    }

    int calculate(int a, int b, string operation) {
        if (operation == "+") {
            return b+a;
        } else if (operation == "-") {
            return b-a;
        } else if (operation == "*") {
            return b*a;
        } else if (operation == "/") {
            return b/a;
        }

        return 0;
    }
};