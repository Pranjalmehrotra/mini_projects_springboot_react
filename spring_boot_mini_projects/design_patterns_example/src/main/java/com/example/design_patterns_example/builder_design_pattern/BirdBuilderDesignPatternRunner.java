package com.example.design_patterns_example.builder_design_pattern;

public class BirdBuilderDesignPatternRunner {

	private int length;
	private int width;
	private String color;

	private BirdBuilderDesignPatternRunner(BirdBuilder birdBuilder) {
		this.length = birdBuilder.length;
		this.width = birdBuilder.width;
		this.color = birdBuilder.color;

	}

	public static class BirdBuilder {

		private int length;
		private int width;
		private String color;

		public BirdBuilder() {

		}

		public BirdBuilder lengthBuilder(int length) {
			this.length = length;
			return this;
		}

		public BirdBuilder widthBuilder(int width) {
			this.width = width;
			return this;
		}

		public BirdBuilder colorBuilder(String color) {
			this.color = color;
			return this;
		}

		public BirdBuilderDesignPatternRunner buildBirdClass() {
			BirdBuilderDesignPatternRunner birdMainClass = new BirdBuilderDesignPatternRunner(this);
			return birdMainClass;
		}

	}

	public static void main(String[] args) {

		BirdBuilderDesignPatternRunner birdBuilderDesignPatternObject = new BirdBuilderDesignPatternRunner.BirdBuilder().lengthBuilder(12)
				.colorBuilder("Red").widthBuilder(12).buildBirdClass();

	}
}
