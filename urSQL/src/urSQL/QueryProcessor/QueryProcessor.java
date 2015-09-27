package urSQL.QueryProcessor;

import java.util.*;

import org.antlr.runtime.*;

import java.io.*;
import java.nio.charset.*;

public class QueryProcessor {
	private String query;
	private PrintWriter writer;
	
	public QueryProcessor() {
		this.query = "";
		try {
			this.writer = new PrintWriter("historico_consultas.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public QueryProcessor(String sql) {
		this.query = sql;
		try {
			this.writer = new PrintWriter("historico_consultas.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setQuery(String sql) {
		this.query = sql;
	}
	
	public void start_cli() throws IOException {
		System.out.println("========= urSQL CLI =========\n");
		boolean flag = true;
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.print(">>> ");
			this.query = scanner.nextLine();
			if (this.query.equals("exit")) {
				flag = false;
				this.writer.close();
			} else {
				this.execute();
			}
		}
	}
	
	public void execute() throws IOException {
		InputStream stream = new ByteArrayInputStream(this.query.getBytes(StandardCharsets.UTF_8));
		ANTLRInputStream input = new ANTLRInputStream(stream);
		urSQLLexer lexer = new urSQLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream((TokenSource) lexer);
		urSQLParser parser = new urSQLParser(tokens);
		parser.programa();
		if (parser.getStatus())
		{
			this.writer.println(this.query + "\t\t" + "Ejecutada");
			this.writer.close();
		} else
		{
			this.writer.println(this.query + "\t\t" + "No ejecutada");
			this.writer.close();
		}
	}

	public static void main(String[] args) throws IOException {
		QueryProcessor q = new QueryProcessor();
		q.start_cli();
	}
}	