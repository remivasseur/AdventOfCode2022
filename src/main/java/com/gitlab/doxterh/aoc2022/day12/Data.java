package com.gitlab.doxterh.aoc2022.day12;

public class Data {

	public static final String TEST = """
			Sabqponm
			abcryxxl
			accszExk
			acctuvwj
			abdefghi""";

	public static final String GAME = """
			abccccccaaccaaccccaaaaacccccaaaaccccccccccccccccccccccccccccccccaaaaaaaaaaaaaaaaaaaccccccccccccccccaaaccccccccccccaacccccccccccccccccccccccccccccccccccccccccaaaa
			abaaaaccaaaaaccccaaaaaccccccaaaaccccccccccccccccccccaaacccccccccccaaaaaaaaaaaaaaaaaaccccccccccccccccaaaaccccccaaacaaccccccccccccccccccccccccccccccccccccccccaaaaa
			abaaacccaaaaaaaacaaaaaacccccaaaaccccccccccccccccccccaaaaacccccccccaaaaaaaaaaaaaaaaacccccccccaaccccaaaaaacccccccaaaaaccccaaccccccccccccccacccccccccccccccccccaaaaa
			abaaacccccaaaaaccccaaaaccccccaaacccccccccccccccccccaaaaaccccccccccaaaaaacacaaaaaacccccccccccaaccccaaaaacccccccccaaaaaaccaaaaaaccccccccccaaaccccacccccccccccaaaaaa
			abaacccccaaaaaccccaacccccccccccccccaaaaacccccccccccaaaaacccccccccaaaaaaaaccaaaaaaacccccccaaaaaaaaccaaaaacccccccaaaaaaaccaaaaacccccccccccaaacccaaaccccccccccccccaa
			abaaacccaaacaacccccccccccccccccccccaaaaaccccccccccccaaaaacccccccaaaaaaaaaccaaccaaacccccccaaaaaaaaccaacccccccccaaaaaaccaaaaaaccccccccccccaaaacaaaaccccccccccccccaa
			abaaacccccccaaccccccccccccccccccccaaaaaaccccccccccccaaccccccaacccaaaccaaaaccccccaacccccccccaaaacccccccccccccccaacaaaccaaaaaaaccccccccccccajjjjjjjcccccccccccccccc
			abcaacccccccccccccccccccccccccccccaaaaaaccccccccccccccccccccaaaaccccccaaaaccccccccccccccaacaaaaaccccccccccccccccccaaccccaaaaaacccccccccccjjjjjjjjjcccccaaaccccccc
			abccccccccccccccccccccccccccccccccaaaaaaccaaccccccccccccccaaaaaacccccccaaacccccccccccaacaaaaaaaaccccccccccccccccccccccccaaccaaccccccccaiijjjjojjjjcccccaaacaccccc
			abcccccccccccccccccccccccaaacccccccaaacacaaacccccccccccccccaaaaccccaaccccccccccccccccaaaaaaacccaccccccccccccccccccccccccaacccccccccccaiiijjooooojjkccaaaaaaaacccc
			abccccccccccccccccccccccaaaaccccccccccaaaaaccccccccccccccccaaaaacccaaaaaccccccccccccccaaaaaacccccccccccccccccccccccccccccccccccccciiiiiiiioooooookkkcaaaaaaaacccc
			abccccccccccccccccccccccaaaaccccccccccaaaaaaaacccccccccccccaacaaccaaaaacccccccaaacccaaaaaaaaccccccccccccccccccccccccccccccccccchiiiiiiiiooooouoookkkccaaaaaaccccc
			abcccccccccaaccccccccccccaaaccccccccccccaaaaacccccccccccccccccccccaaaaaccccccaaaacccaaaaacaacccccccccccccaacaacccccccccccccccchhhiiiinnnooouuuuoookkkccaaaaaccccc
			abcccccccccaaacccccccccccccccccccccccccaaaaacccccccccccccccccccccccaaaaacccccaaaaccccccaaccccccccccccccccaaaaacccccccccccccccchhhnnnnnnnnouuuuuuppkkkkaaaaaaccccc
			abccccccaaaaaaaacccaaccccccccccccccccccaacaaccaacaaccccccccccccccccaacccccccccaaaccccccaacccccccccccccccaaaaacccccccccccccccchhhnnnnnnnnntuuxuuupppkkkkkacccccccc
			abccccccaaaaaaaacacaaaacccccccccccccccccccaaccaaaaacccccccccccccccccccccccccccccccccccccccccccccccccccccaaaaaacccccccaacccccchhhnnnnttttttuxxxuuppppkkkkkcccccccc
			abcccccccaaaaaaccaaaaaaccccccccccaaccccccccccaaaaaccccccccccccccccccccccccaaacccccccccccccccccccccccccccccaaaaccaaccaaacccaaahhhnnntttttttuxxxxuupppppllllccccccc
			abcccccccaaaaaacccaaaacccccccccaaaaaaccccccccaaaaaacccccccccccccccccccccccaaacccccccccccccccccccccccccccccacccccaaaaaaacaaaaahhhppntttxxxxxxxxuuuuvpppplllccccccc
			abcccccccaaaaaacccaaaacccccccccaaaaaacccccaaaaaaaaaccccccccccccccccccccaaaaaaaacccccccccccccccccccccaaaccccccaacaaaaaaccaaaaahhhpppttxxxxxxxxyuuvvvvvppplllcccccc
			abcccccccaaccaacccaacaccaaaaccccaaaaacccccaaaaaaaaaccccccccccccccccccccaaaaaaaacccccccccccccccccccccaaacaaaaaaaccaaaaaaaaaaaaahhppptttxxxxxxyyyyyyvvvppplllcccccc
			SbccccccccccccccccccccccaaaacccaaaaacccccccaaaaaaaaacaaaccccccccaacccccccaaaaaccccccccaaaaacccccccccaaaaaaaaaaaaaaaaaaaaaaaaacgggpppttxxxxEzzyyyyyvvvqqqlllcccccc
			abccccccccccccccccccccccaaaacccaaaaacccccccaaaaaaaaccaaaccccccccaaacaaccaaaaaaccccccccaaaaacccccccaaaaaaaaaaaaaaaaaaaaaaaaaaacgggpppsssxxxyyyyyyvvvvvqqlllccccccc
			abcccaaaccccccccccccccccaaaccccccccccccccccaaaaaaaaaaaaaccccccccaaaaaaccaaaaaacccccccaaaaaacccaaaccaaaaaccaaaaaaaaaaaacccccccccgggppssswwyyyyyyvvvvqqqqlllccccccc
			abcaaaaaccccccccccccccccccccccccccccccccccaaaaaaaaaaaaacccccccaaaaaaacccaccaaacccccccaaaaaacccaaacccaaaaaaaaaaaccccaaacccaaaaacgggppsswwwyyyyyyvvqqqqqlllcccccccc
			abcaaaaaaccccccccccccccccccccccccccccccccccaaccaaaaaaaaaaaccccaaaaaaacccccccccccccccccaaaaacccaaacaaaacaaaaaaaaccccaaacccaaaaacggpppsswwwywwyyyvvqqqmmmlccccccccc
			abcaaaaaacccccccaacaaccccccccccccccccccccccccccaaaaaaaaaaaccccccaaaaacccccccccccccccccaaaccaaaaaaaaaaacccccccaacccccccccaaaaaacggpppsswwwwwwwwyvvqqqmmmcccccccccc
			abcaaaaaccccccccaaaaaccccccccccccccccccccccccccccaaaaaaaacccccccaacaaacccccccccccccccccccccaaaaaaaaaccccccccccccccccccccaaaaaagggoossswwwwrrwwwvvqqmmmccccccccccc
			abcaaaaacccccccaaaaaccccccccccccccccccccccccccccaaaaaaacccccccccaaccccccccccccccccccccccccccaaaaaaacccccccccccaaaccccccccaaaaagggooosssssrrrrwwwvqqmmmcccaacccccc
			abcccccccccccccaaaaaaccccccccccccccccccccaacccccccccaaaccccccccccccccccccccccccccccccccccccccaaaaaaccccccccccccaaaaccccccaaaccgggooosssssrrrrrwwrrqmmmcccaacccccc
			abcccccccccccccccaaaacccccccccccccccccccaaaacccccccacaaacccccccccccccccccccccccccccccccccccccaaaaaaacccccccccaaaaaacccccccccccgffoooooosoonrrrrrrrrmmmccaaaaacccc
			abcccccccccccccccaccccccccccccccccccccccaaaacccccccaaaaacccccccccccccccccccccccccccccccccccccaaacaaacccccccccaaaaacccccccccccccfffoooooooonnnrrrrrmmmddcaaaaacccc
			abccccccccccccccccccccccccccccccccccccccaaaaccccccccaaaaacccccccccccccccccccccccccaaaccccccccaacccccccccccccccaaaaaccccccccccccffffoooooonnnnnnrnnmmmdddaaaaacccc
			abcccccccccccccccccccccccccccccccccccccccccccccccccaaaaaacccccccccccccccccaaaaaccaaaacccccccccccccccccccccccccaacccccccccccccccfffffffffeeeennnnnnmmdddaaaacccccc
			abcccccccaaaccccccccaccccccccccccccccccccccccccccccaaaaccccccccccccaaaccccaaaaaccaaaaccccccccccccccccccccccccccccccccccccccccccccfffffffeeeeennnnnmddddaaaaaccccc
			abcccaaccaaacccccaaaacccccaacccccccccccccccccccccccccaaacccccccccccaaacccaaaaaacccaaaccccccccccccccccccccccccccccccccccccccccccccccffffeeeeeeeedddddddcccaacccccc
			abcccaaaaaaacccccaaaaaaccaaacccccccccccccccccccccccccccacccccccccccaaaaccaaaaaaccccccccccccccccccccccccccaacccccccccaaaccccccccccccccaaaaaaeeeeedddddcccccccccccc
			abcccaaaaaacccccccaaaacccaaacaaaccccaaaacccccccccaaacaaaccccccaacccaaaacaaaaaaacccccccccccccccccccccccccaaaccccccccaaaacccccccccccccccccccaaaaeeddddccccccccccccc
			abccccaaaaaaaacccaaaaaaaaaaaaaaaccccaaaacccccccccaaaaaaacccccaaacccaaaaaaaaaacccccccccccccccccccccccaaacaaaccccccccaaaaccccccccccccccccccccaaaccccccccccccccaaaca
			abcccaaaaaaaaacccaacaaaaaaaaaaacccccaaaaccccccccccaaaaaacaaacaaacaaaaaaaaaacccccccccccccccaaacccccccaaaaaaaaaaccccccaaaccccccccccccccccccccaacccccccccccccccaaaaa
			abcccaaaaaaaacccccccccccaaaaaacccccccaacccccccccccaaaaaaaaaaaaaaaaaaaaaaaaccccccccccccccccaaaacccccccaaaaaaaaacccccccccccccccccccccccccccccaaacccccccccccccccaaaa
			abccaaaaaaacccccccccccccaaaaaaacccccccccccccccccaaaaaaaaaaaaaaaaaaaaaaaaaaacccccccccccccccaaaacccccccaaaaaaaacccccccccccccccccccccccccccccccccccccccccccccccaaaaa""";
}
