package com.scaler.TicTacToe.Validations;

import com.scaler.TicTacToe.Exceptions.UniquePlayerException;
import com.scaler.TicTacToe.Models.Player;
import com.scaler.TicTacToe.Models.Symbol;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniquePlayersValidation {
    public static void checkUniqueSymbol(List<Player> players){
        Set<Character> symbols = new HashSet<>();
        for(Player player : players){
            if(symbols.contains(player.getSymbol().getSymchar())){
                throw new UniquePlayerException("Players must have unique symbols");
            }else{
                symbols.add(player.getSymbol().getSymchar());
            }
        }
    }
}
