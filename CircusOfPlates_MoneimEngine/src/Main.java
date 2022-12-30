
import View.GamePanel;
import eg.edu.alexu.csd.oop.game.GameEngine;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmedmoneimm
 */
public class Main {
    public static void main(String[] args){
            GameEngine.start("Game",
                    new GamePanel(1000,500));
        }
    }
