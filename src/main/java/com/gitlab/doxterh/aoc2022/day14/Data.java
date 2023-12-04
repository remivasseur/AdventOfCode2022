package com.gitlab.doxterh.aoc2022.day14;

public class Data {

	public static final String TEST = """
			498,4 -> 498,6 -> 496,6
			503,4 -> 502,4 -> 502,9 -> 494,9""";

	public static final String GAME = """
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			482,143 -> 487,143
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			495,81 -> 495,83 -> 494,83 -> 494,91 -> 505,91 -> 505,83 -> 501,83 -> 501,81
			487,32 -> 491,32
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			478,106 -> 478,108 -> 472,108 -> 472,112 -> 489,112 -> 489,108 -> 483,108 -> 483,106
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			484,35 -> 488,35
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			478,106 -> 478,108 -> 472,108 -> 472,112 -> 489,112 -> 489,108 -> 483,108 -> 483,106
			498,13 -> 498,16 -> 490,16 -> 490,23 -> 511,23 -> 511,16 -> 503,16 -> 503,13
			482,103 -> 486,103
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			478,106 -> 478,108 -> 472,108 -> 472,112 -> 489,112 -> 489,108 -> 483,108 -> 483,106
			478,106 -> 478,108 -> 472,108 -> 472,112 -> 489,112 -> 489,108 -> 483,108 -> 483,106
			494,103 -> 498,103
			476,38 -> 476,39 -> 484,39 -> 484,38
			489,70 -> 493,70
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			498,13 -> 498,16 -> 490,16 -> 490,23 -> 511,23 -> 511,16 -> 503,16 -> 503,13
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			469,115 -> 469,119 -> 466,119 -> 466,124 -> 476,124 -> 476,119 -> 472,119 -> 472,115
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			495,81 -> 495,83 -> 494,83 -> 494,91 -> 505,91 -> 505,83 -> 501,83 -> 501,81
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			498,13 -> 498,16 -> 490,16 -> 490,23 -> 511,23 -> 511,16 -> 503,16 -> 503,13
			498,13 -> 498,16 -> 490,16 -> 490,23 -> 511,23 -> 511,16 -> 503,16 -> 503,13
			478,106 -> 478,108 -> 472,108 -> 472,112 -> 489,112 -> 489,108 -> 483,108 -> 483,106
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			469,115 -> 469,119 -> 466,119 -> 466,124 -> 476,124 -> 476,119 -> 472,119 -> 472,115
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			469,115 -> 469,119 -> 466,119 -> 466,124 -> 476,124 -> 476,119 -> 472,119 -> 472,115
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			495,70 -> 499,70
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			472,146 -> 477,146
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			478,140 -> 483,140
			481,32 -> 485,32
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			478,106 -> 478,108 -> 472,108 -> 472,112 -> 489,112 -> 489,108 -> 483,108 -> 483,106
			469,115 -> 469,119 -> 466,119 -> 466,124 -> 476,124 -> 476,119 -> 472,119 -> 472,115
			483,149 -> 488,149
			496,35 -> 500,35
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			469,115 -> 469,119 -> 466,119 -> 466,124 -> 476,124 -> 476,119 -> 472,119 -> 472,115
			499,77 -> 499,78 -> 509,78 -> 509,77
			478,106 -> 478,108 -> 472,108 -> 472,112 -> 489,112 -> 489,108 -> 483,108 -> 483,106
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			492,68 -> 496,68
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			486,146 -> 491,146
			476,38 -> 476,39 -> 484,39 -> 484,38
			469,149 -> 474,149
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			479,146 -> 484,146
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			495,81 -> 495,83 -> 494,83 -> 494,91 -> 505,91 -> 505,83 -> 501,83 -> 501,81
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			495,81 -> 495,83 -> 494,83 -> 494,91 -> 505,91 -> 505,83 -> 501,83 -> 501,81
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			498,13 -> 498,16 -> 490,16 -> 490,23 -> 511,23 -> 511,16 -> 503,16 -> 503,13
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			458,165 -> 458,166 -> 473,166 -> 473,165
			469,115 -> 469,119 -> 466,119 -> 466,124 -> 476,124 -> 476,119 -> 472,119 -> 472,115
			486,72 -> 490,72
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			491,96 -> 501,96 -> 501,95
			475,143 -> 480,143
			498,72 -> 502,72
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			495,81 -> 495,83 -> 494,83 -> 494,91 -> 505,91 -> 505,83 -> 501,83 -> 501,81
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			476,38 -> 476,39 -> 484,39 -> 484,38
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			478,35 -> 482,35
			490,29 -> 494,29
			495,81 -> 495,83 -> 494,83 -> 494,91 -> 505,91 -> 505,83 -> 501,83 -> 501,81
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			458,165 -> 458,166 -> 473,166 -> 473,165
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			498,13 -> 498,16 -> 490,16 -> 490,23 -> 511,23 -> 511,16 -> 503,16 -> 503,13
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			491,96 -> 501,96 -> 501,95
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			487,26 -> 491,26
			485,101 -> 489,101
			491,101 -> 495,101
			475,65 -> 475,60 -> 475,65 -> 477,65 -> 477,58 -> 477,65 -> 479,65 -> 479,57 -> 479,65 -> 481,65 -> 481,60 -> 481,65 -> 483,65 -> 483,55 -> 483,65 -> 485,65 -> 485,64 -> 485,65 -> 487,65 -> 487,64 -> 487,65 -> 489,65 -> 489,60 -> 489,65 -> 491,65 -> 491,63 -> 491,65 -> 493,65 -> 493,64 -> 493,65
			492,72 -> 496,72
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			495,81 -> 495,83 -> 494,83 -> 494,91 -> 505,91 -> 505,83 -> 501,83 -> 501,81
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			490,149 -> 495,149
			488,99 -> 492,99
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			493,32 -> 497,32
			499,77 -> 499,78 -> 509,78 -> 509,77
			458,165 -> 458,166 -> 473,166 -> 473,165
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			490,35 -> 494,35
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			499,77 -> 499,78 -> 509,78 -> 509,77
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			472,137 -> 472,136 -> 472,137 -> 474,137 -> 474,134 -> 474,137 -> 476,137 -> 476,127 -> 476,137 -> 478,137 -> 478,129 -> 478,137 -> 480,137 -> 480,132 -> 480,137
			498,13 -> 498,16 -> 490,16 -> 490,23 -> 511,23 -> 511,16 -> 503,16 -> 503,13
			469,115 -> 469,119 -> 466,119 -> 466,124 -> 476,124 -> 476,119 -> 472,119 -> 472,115
			476,149 -> 481,149
			468,162 -> 468,158 -> 468,162 -> 470,162 -> 470,159 -> 470,162 -> 472,162 -> 472,156 -> 472,162 -> 474,162 -> 474,157 -> 474,162 -> 476,162 -> 476,152 -> 476,162 -> 478,162 -> 478,158 -> 478,162 -> 480,162 -> 480,155 -> 480,162
			465,52 -> 465,44 -> 465,52 -> 467,52 -> 467,51 -> 467,52 -> 469,52 -> 469,44 -> 469,52 -> 471,52 -> 471,51 -> 471,52 -> 473,52 -> 473,50 -> 473,52 -> 475,52 -> 475,44 -> 475,52 -> 477,52 -> 477,44 -> 477,52 -> 479,52 -> 479,43 -> 479,52 -> 481,52 -> 481,48 -> 481,52 -> 483,52 -> 483,46 -> 483,52
			484,29 -> 488,29
			488,103 -> 492,103""";
}
