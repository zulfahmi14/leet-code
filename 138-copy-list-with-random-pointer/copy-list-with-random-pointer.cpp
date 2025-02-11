/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
private:
    Node* copyLink(Node* head) {
        if (head == NULL) return NULL;
        else {
            Node* cp = new Node(head->val);
            cp->next = copyLink(head->next);
            return cp;
        }
    }

    void addRandomLink(Node* head, Node* node, Node* loop, Node* loop2) {
        while (loop != NULL) {
            if (loop == head->random) {
                node->random = loop2;
                return;
            }

            loop = loop->next;
            loop2 = loop2->next;
        }
    }

    void searchRandomLink(Node* head, Node* ans) {
        Node* temp2 = ans;
        Node* temp = head;
        while(temp != NULL) {
            if (temp->random != NULL) {
                addRandomLink(temp, temp2, head, ans);
            }

            temp = temp->next;
            temp2 = temp2->next;
        }
    }

public:
    Node* copyRandomList(Node* head) {
        Node* ans = copyLink(head);
        searchRandomLink(head, ans);
        return ans;
    }
};