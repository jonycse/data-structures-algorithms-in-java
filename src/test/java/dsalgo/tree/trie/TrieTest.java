package dsalgo.tree.trie;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrieTest {


    @Test
    @DisplayName("Trie Test")
    void test1() {
        Trie trie = new Trie();

        trie.insert("abc");
        trie.insert("abcdefgh");

        // test prefix
        Assertions.assertEquals(true, trie.containsPrefix("abcd"));
        Assertions.assertEquals(true, trie.containsPrefix("abcde"));
        Assertions.assertEquals(true, trie.containsPrefix("abcdefgh"));
        Assertions.assertEquals(false, trie.containsPrefix("abcdefxh"));

        trie.insert("abcdef");
        trie.insert("abcd");
        trie.insert("d");

        Assertions.assertEquals(true, trie.contains("abc"));
        Assertions.assertEquals(true, trie.contains("abcdef"));
        Assertions.assertEquals(true, trie.contains("d"));
        Assertions.assertEquals(false, trie.contains("a"));
        Assertions.assertEquals(false, trie.contains("ab"));
        Assertions.assertEquals(false, trie.contains("abcdefg"));
        Assertions.assertEquals(true, trie.contains("abcd"));


        trie.delete("ab");
        Assertions.assertEquals(true, trie.contains("abc"));
        trie.delete("abcdef");
        Assertions.assertEquals(true, trie.contains("abcd"));
        Assertions.assertEquals(true, trie.contains("abcdefgh"));
        Assertions.assertEquals(false, trie.contains("abcdef"));
        trie.delete("d");
        trie.delete("x");
        Assertions.assertEquals(false, trie.contains("d"));
        Assertions.assertEquals(false, trie.contains("x"));

        System.out.println("Delete");
        trie.insert("xyz");
        trie.insert("xyz1");
        trie.delete("xyz1");
        Assertions.assertEquals(true, trie.contains("xyz"));

        trie.insert("xyz1234");
        trie.delete("xyz1234");
        Assertions.assertEquals(true, trie.contains("xyz"));
    }

    @Test
    @DisplayName("Trie Prefix")
    void test3() {
        Trie trie = new Trie();

        trie.insert("abc");
        trie.insert("abcdefgh");
        trie.insert("abcdef");
        trie.insert("abcd");
        trie.insert("abd");
        trie.insert("abdX");
        trie.insert("abdA");
        trie.insert("abdAA");
        trie.insert("abdAD");
        trie.insert("abdAC");
        trie.insert("abdAB");
        trie.insert("abdC");
        trie.insert("abdB");
        trie.insert("d");

        String prefix = "abc";
        List<String> words = trie.getPrefixWords(prefix);
        System.out.println("For prefix " + prefix);

        prefix = "abd";
        words = trie.getPrefixWords(prefix);
        System.out.println("For prefix " + prefix);

        Assert.assertEquals(0, words.indexOf("abd"));
        Assert.assertEquals(1, words.indexOf("abdA"));
        Assert.assertEquals(2, words.indexOf("abdAA"));
        Assert.assertEquals(3, words.indexOf("abdAB"));
        Assert.assertEquals(4, words.indexOf("abdAC"));
        Assert.assertEquals(5, words.indexOf("abdAD"));
        Assert.assertEquals(6, words.indexOf("abdB"));
        Assert.assertEquals(7, words.indexOf("abdC"));
        Assert.assertEquals(8, words.indexOf("abdX"));
    }
}

