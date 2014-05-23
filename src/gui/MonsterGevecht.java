/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import domein.Held;
import domein.Monster;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Stef
 */
public class MonsterGevecht extends BorderPane
{
    public Held held;
    public Monster monster;
    public ProgressBar heldVerdediging;
    public ProgressBar monsterVerdediging;
    public Label lblMonsterNaam;
    public Label lblHeldNaam;
    public ImageView ivMonsterImage;
    public ImageView ivHeldImage;
    
    
    public MonsterGevecht(Held held, Monster monster)
    {
        this.held = held;
        this.monster = monster;
        
        VBox vHeld = new VBox();
        VBox vMonster = new VBox();
        
        vHeld.getChildren().addAll(lblMonsterNaam, heldVerdediging, ivHeldImage);
        vMonster.getChildren().addAll(lblHeldNaam, monsterVerdediging, ivMonsterImage);
        
        vHeld.setAlignment(Pos.CENTER_LEFT);
        vMonster.setAlignment(Pos.CENTER_RIGHT);
    }
}
