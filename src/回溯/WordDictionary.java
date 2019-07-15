package 回溯;

import java.util.HashMap;

public class WordDictionary {

	private class Node {
		private boolean isWord;
		private HashMap<Character, Node> next;

		public Node() {
			isWord = false;
			next = new HashMap<>();
		}
	}

	Node root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new Node();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		addWord(word, 0, root);
	}

	private void addWord(String word, int index, Node node) {
		if (index == word.length()) {
			node.isWord = true;
			return;
		}

		char c = word.charAt(index);
		if (node.next.get(c) == null)
			node.next.put(c, new Node());
		addWord(word, index + 1, node.next.get(c));
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return search(word, 0, root);
	}

	private boolean search(String word, int index, Node node) {
		if (index == word.length())
			return node.isWord;

		char c = word.charAt(index);
		if (c == '.') {
			HashMap<Character, Node> map = node.next;
			boolean flag = false;
			for (char s : map.keySet()) {
				flag = search(word, index + 1, node.next.get(s));
				// 当有成功的分支，直接返回 true
				if (flag)
					return flag;
			}
			// 所有分支都不成立，返回false
			return false;
		} else {
			if (node.next.get(c) == null)
				return false;
			return search(word, index + 1, node.next.get(c));
		}

	}

}