struct Node{
    Node* nodes[30]={nullptr};
    bool endWord = false;
};

class WordDictionary {
private:
    Node* head;

    void addToNode(Node*& node, string word) {
        if (node == nullptr) {
            node = new Node();
        }

        if (word.size() <= 0) {
            node->endWord = true;
            return;
        }

        addToNode(node->nodes[word[0]-'a'], word.substr(1));
    }

    bool searchInNode(Node*& node, string word) {
        if (node == nullptr) {
            return false;
        }

        if (word.size() == 0) {
            return node->endWord;
        }

        bool result = false;

        if (word[0] == '.') {
            for(int i=0;i<30;i++) {
                result = result || searchInNode(node->nodes[i], word.substr(1));
            }
        } else {
            result = searchInNode(node->nodes[word[0]-'a'], word.substr(1));
        }

        return result;
    }

public:
    WordDictionary() {
        this->head = new Node();
    }
    
    void addWord(string word) {
        addToNode(this->head->nodes[word[0]-'a'], word.substr(1));
    }
    
    bool search(string word) {
        bool result = false;
        if (word[0] == '.') {
            for(int i=0;i<30;i++) {
                result = result || searchInNode(this->head->nodes[i], word.substr(1));
            }
        } else {
            result = searchInNode(this->head->nodes[word[0]-'a'], word.substr(1));
        }

        return result;
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */