package com.greenteam.captainsquarters;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class PirateInvaders extends Game {

//	GameScreen gameScreen;
	MainMenuScreen mainMenuScreen;

	public static Random random = new Random();

	@Override
	public void create() {
//		gameScreen = new GameScreen();
//		setScreen(gameScreen);
		mainMenuScreen = new MainMenuScreen();
		setScreen(mainMenuScreen);
	}

	@Override
	public void dispose() {
//		gameScreen.dispose();
		mainMenuScreen.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
//		gameScreen.resize(width, height);
		mainMenuScreen.resize(width, height);
	}
}
