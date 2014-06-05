package com.codeaffine.gonsole.internal;

import java.io.File;
import java.io.OutputStream;

public class GitInterpreter {

  private final PgmResourceBundle pgmResourceBundleInitializer;
  private final CommandExecutor commandExecutor;
  private final CommandLineParser commandLineParser;

  public GitInterpreter( OutputStream outputStream, File gitDirectory ) {
    this( new PgmResourceBundle(),
          new CommandExecutor( outputStream, gitDirectory ),
          new CommandLineParser() );
  }

  GitInterpreter( PgmResourceBundle pgmResourceBundleInitializer,
                  CommandExecutor commandExecutor,
                  CommandLineParser commandLineParser )
  {
    this.pgmResourceBundleInitializer = pgmResourceBundleInitializer;
    this.commandExecutor = commandExecutor;
    this.commandLineParser = commandLineParser;
  }

  public void execute( String... commandLine ) {
    pgmResourceBundleInitializer.initialize();
    CommandInfo commandInfo = commandLineParser.parse( commandLine );
    commandExecutor.execute( commandInfo );
  }
}