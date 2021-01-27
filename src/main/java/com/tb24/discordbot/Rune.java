package com.tb24.discordbot;

import com.tb24.discordbot.commands.CommandSourceStack;

import java.util.Arrays;

import static com.rethinkdb.RethinkDB.r;

public class Rune {
	public static boolean isBotDev(CommandSourceStack source) {
		return Arrays.asList(
			624299014388711455L, // amr
			299693897859465228L, // kemo
			335937477997101056L, // potato
			175279476245004288L // m4tonoob
		).contains(source.getAuthor().getIdLong());
	}

	public static boolean hasAccess(CommandSourceStack source) {
		return r.table("members").get(source.getAuthor().getId()).run(source.getClient().dbConn).first() != null;
	}
}
