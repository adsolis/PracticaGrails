package practica

import grails.transaction.Transactional


@Transactional
class PersonaService {

    def utilService

    Persona guardarPersona(params) {

        Persona persona = new Persona(params)
        persona.save(flush: true, failOnError: true)
        persona

    }

    Persona consultarPersona(Long id) {
        Persona persona = Persona.get(id)
        persona.edad = utilService.calcularEdad(persona.fechaNacimiento)
        persona
    }


    List<Persona> listarPersonas(params) {
        params.nombre = "Alex"
        params.apellidoPaterno = "Diaz"
        params.fechaNacimiento = new Date()
        params.edad = 26
        guardarPersona(params)
        List<Persona> listaPersonas = Persona.list()
        listaPersonas
    }
}
