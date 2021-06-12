package sistema.advogados.associados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sistema.advogados.associados.model.Usuario;
import sistema.advogados.associados.service.UsuarioService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(value="/obter-usuarios", method=RequestMethod.GET)
	public ModelAndView obterUsuarios(ModelAndView model, @PageableDefault(size = 20) Pageable pageable) {
		
		try {
			
			Page<Usuario> usuarios = usuarioService.obterUsuariosPaginados(pageable);
			
			model.addObject("page", pageable.getPageNumber());
			
			model.addObject("size", pageable.getPageSize());
			
			model.addObject("usuariosPaginados", usuarios);
			
			model.setViewName("listar-usuario");
			
			return model;
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value="/obter-usuario-por-id", method=RequestMethod.GET)
	public ModelAndView obterUsuarioPorId(ModelAndView model, @RequestParam(value="id") Long id) {
		
		try {
			
			Usuario usuario = usuarioService.obterUsuario(id);
			
			model.addObject("usuario", usuario);
			
			model.setViewName("edicao-usuario");
			
			return model;
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value="/obter-usuario-por-login", method=RequestMethod.GET)
	public ModelAndView obterUsuarioPorLogin(ModelAndView model, @RequestParam(value="login") String login) {
		
		try {
			
			Usuario usuario = usuarioService.obterUsuarioPorLogin(login);
			
			model.addObject("usuario", usuario);
			
			model.setViewName("edicao-usuario");
			
			return model;
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
