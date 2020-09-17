package dsalgo.tree.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Trie {

    public class TrieNode {

        public SortedMap<Character, TrieNode> children = new TreeMap<>();
        private boolean endOfWord;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            TrieNode node = currentNode.children.get(c);
            if (node == null) {
                node = new TrieNode();
                currentNode.children.put(c, node);
            }
            currentNode = node;
        }
        currentNode.endOfWord = true;
    }

    public TrieNode getPrefixNode(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = currentNode.children.get(word.charAt(i));
            if (node == null) {
                return null;
            }
            currentNode = node;
        }
        return currentNode;
    }

    /**
     * This provides us sorted auto-complete feature
     * @param prefix
     * @return
     */
    public List<String> getPrefixWords(String prefix) {
        List<String> words = new ArrayList<>();

        TrieNode prefixNode = getPrefixNode(prefix);
        if (prefixNode != null) {

            populate(new StringBuilder(prefix), prefixNode, words);
        }
        return words;
    }

    private void populate(StringBuilder prefix, TrieNode cNode, List<String> words) {
        if (cNode.endOfWord) {
            words.add(prefix.toString());
        }
        for (Character c : cNode.children.keySet()) {
            prefix.append(c);
            populate(prefix, cNode.children.get(c), words);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public boolean contains(String word) {
        TrieNode prefixNode = getPrefixNode(word);
        return prefixNode != null && prefixNode.endOfWord;
    }

    public boolean containsPrefix(String word) {
        return getPrefixNode(word) != null;
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {

        if (word.length() == index) {
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            return current.children.isEmpty();
        }

        Character c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if (node == null) {
            return false;
        }

        boolean shouldDelete = delete(node, word, index + 1) && !node.endOfWord;
        // only remove if node has no child and node is not end of the word.
        // for current node we already set endOfWord to false on base condition
        if (shouldDelete) {
            current.children.remove(c);
            return current.children.isEmpty();
        }
        return false;
    }
}
