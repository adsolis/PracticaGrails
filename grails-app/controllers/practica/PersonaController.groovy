package practica

class PersonaController {

    def personaService

    def index() {

        List<Persona> personas = personaService.listarPersonas(params)
        render(view: '/persona/index', model: [personas: personas])

    }
}
