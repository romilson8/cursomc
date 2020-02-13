package br.com.banzo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.banzo.domain.Categoria;
import br.com.banzo.domain.Cidade;
import br.com.banzo.domain.Cliente;
import br.com.banzo.domain.Endereco;
import br.com.banzo.domain.Estado;
import br.com.banzo.domain.ItemPedido;
import br.com.banzo.domain.Pagamento;
import br.com.banzo.domain.PagamentoComBoleto;
import br.com.banzo.domain.PagamentoComCartao;
import br.com.banzo.domain.Pedido;
import br.com.banzo.domain.Produto;
import br.com.banzo.domain.enums.EstadoPagamento;
import br.com.banzo.domain.enums.TipoCliente;
import br.com.banzo.repositories.CategoriaRepository;
import br.com.banzo.repositories.CidadeRepository;
import br.com.banzo.repositories.ClienteRepository;
import br.com.banzo.repositories.EnderecoRepository;
import br.com.banzo.repositories.EstadoRepository;
import br.com.banzo.repositories.ItemPedidoRepository;
import br.com.banzo.repositories.PagamentoRepository;
import br.com.banzo.repositories.PedidoRepository;
import br.com.banzo.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria("Informática");
		Categoria cat2 = new Categoria("Escritório");
		Categoria cat3 = new Categoria("Cama mesa e banho");
		Categoria cat4 = new Categoria("Eletrônicos");
		Categoria cat5 = new Categoria("Jardinagem");
		Categoria cat6 = new Categoria("Decoração");
		Categoria cat7 = new Categoria("Perfumaria");

		Produto p1 = new Produto("Computador", 2000.00);
		Produto p2 = new Produto("Impressora", 800.00);
		Produto p3 = new Produto("Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est2 = new Estado("Minas Gerais");
		Estado est1 = new Estado("São Paulo");

		Cidade c1 = new Cidade("Campinas", est1);
		Cidade c2 = new Cidade("São Paulo", est1);
		Cidade c3 = new Cidade("Uberlandia", est2);

		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente("Maria Silva", "maria@gmail.com", "04044364477", TipoCliente.PESSOA_FISICA);

		cli1.getTelefones().addAll(Arrays.asList("996759966", "94985566"));

		Endereco e1 = new Endereco("Rua das Flores", "300", "Apt 303", "Jardim", "3822083", cli1, c3);
		Endereco e2 = new Endereco("Avenida Mattos", "105", "sala 800", "Centro", "51030510", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));

		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1));

		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);

		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);

		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
