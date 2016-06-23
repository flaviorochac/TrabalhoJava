package br.univel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArquivoReaderTest.class, ClienteParserTest.class, ProdutoParserTest.class })
public class AllTests {

}
