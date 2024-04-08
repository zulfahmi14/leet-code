struct Node {
    Node* nodes[30] = {nullptr};
    bool endOfStr = false;
};

class Trie {
private:
    Node* head;

    bool searchNode(Node* node, string word) {
        if (node == nullptr) {
            return false;
        }

        if (word.size() == 0) {
            return node->endOfStr;
        }

        return searchNode(node->nodes[word[0]-'a'], word.substr(1));
    }

    bool startsWithNode(Node* node, string word) {
        if (node == nullptr) return false;

        if (word.size() == 0) {
            return true ;
        }

        return startsWithNode(node->nodes[word[0]-'a'], word.substr(1));
    }

    void insertNodes(Node*& node, string word) {

        if (node == nullptr) {
            node = new Node();
        }

        if (word.size() <= 0) {
            node->endOfStr = true;
            return;
        }

        insertNodes(node->nodes[word[0]-'a'], word.substr(1));
    }

public:
    Trie() {
        this->head = new Node();
    }
    
    void insert(string word) {
        return insertNodes(this->head->nodes[word[0]-'a'], word.substr(1));
    }
    
    bool search(string word) {
        return searchNode(this->head->nodes[word[0]-'a'], word.substr(1));
    }
    
    bool startsWith(string prefix) {
        return startsWithNode(this->head->nodes[prefix[0]-'a'], prefix.substr(1));
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */