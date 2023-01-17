package com.desafio.resouces;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.domain.Agente;
import com.desafio.domain.Compra;
import com.desafio.domain.Geracao;
import com.desafio.domain.Regiao;
import com.desafio.dto.AgenteDTO;
import com.desafio.dto.CompraDTO;
import com.desafio.dto.GeracaoDTO;
import com.desafio.dto.RegiaoDTO;
import com.desafio.service.AgenteService;
import com.desafio.service.CompraService;
import com.desafio.service.GeracaoService;
import com.desafio.service.RegiaoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/desafio")
public class AgenteResurces {
	
	private AgenteService service;
	private RegiaoService serviceRegiao;
	private GeracaoService serviceGeracao;
	private CompraService serviceCompra;

	public AgenteResurces(AgenteService service, RegiaoService serviceRegiao, GeracaoService serviceGeracao, CompraService serviceCompra) {
		this.service = service;
		this.serviceRegiao = serviceRegiao;
		this.serviceGeracao = serviceGeracao;
		this.serviceCompra = serviceCompra;
	}

	@GetMapping
	public ResponseEntity<List<GeracaoDTO>> findAll(){
		List<GeracaoDTO> list = serviceGeracao.findAll().stream().map(obj -> new GeracaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<AgenteDTO> create( MultipartFile[] obj) throws IOException{
		int cont = 0;

		if (obj != null) {
			for (int i = 0; i < obj.length; i++) {
				XmlMapper xmlMapper = new XmlMapper();
				JsonNode node = xmlMapper.readTree(obj[i].getBytes());
				JsonNode root1 = node.path("agente");

				if (!root1.isArray()) {
					AgenteDTO agenteDTO = new AgenteDTO();
					agenteDTO.setCodigo(root1.path("codigo").asText());
					agenteDTO.setData(root1.path("data").asText());

					Agente adto = service.create(agenteDTO);

					for (JsonNode reg : root1.path("regiao")) {
						RegiaoDTO regDTO = new RegiaoDTO();
						regDTO.setSigla(reg.path("sigla").asText());
						regDTO.setAgente(adto);

						Regiao regiaoSave = serviceRegiao.create(regDTO);
						JsonNode nodesGeracao = reg.path("geracao").get("valor");

						for (JsonNode gera : nodesGeracao) {
							GeracaoDTO geraDTO = new GeracaoDTO();
							geraDTO.setValor(gera.asText());
							geraDTO.setRegiao(regiaoSave);
							serviceGeracao.create(geraDTO);
						}

						JsonNode nodesCompra = reg.path("compra").get("valor");

						for (JsonNode compra : nodesCompra) {
							CompraDTO comDTO = new CompraDTO();
							comDTO.setCompra(compra.asText());
							comDTO.setRegiao(regiaoSave);
							serviceCompra.create(comDTO);
						}
					}

					cont++;
				} else {
					for (JsonNode root : node.path("agente")) {
						AgenteDTO agenteDTO = new AgenteDTO();
						agenteDTO.setCodigo(root.path("codigo").asText());
						agenteDTO.setData(root.path("data").asText());

						Agente adto = service.create(agenteDTO);

						for (JsonNode reg : root.path("regiao")) {
							RegiaoDTO regDTO = new RegiaoDTO();
							regDTO.setSigla(reg.path("sigla").asText());
							regDTO.setAgente(adto);

							Regiao regiaoSave = serviceRegiao.create(regDTO);
							JsonNode nodesGeracao = reg.path("geracao").get("valor");

							for (JsonNode gera : nodesGeracao) {
								GeracaoDTO geraDTO = new GeracaoDTO();
								geraDTO.setValor(gera.asText());
								geraDTO.setRegiao(regiaoSave);
								serviceGeracao.create(geraDTO);
							}

							JsonNode nodesCompra = reg.path("compra").get("valor");

							for (JsonNode compra : nodesCompra) {
								CompraDTO comDTO = new CompraDTO();
								comDTO.setCompra(compra.asText());
								comDTO.setRegiao(regiaoSave);
								serviceCompra.create(comDTO);
							}
						}

						cont++;
					}
				}
			}
		}

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cont).toUri();
		return ResponseEntity.created(uri).build();
	}
}