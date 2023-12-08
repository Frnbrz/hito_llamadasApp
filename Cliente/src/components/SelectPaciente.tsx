import {useEffect, useState} from "react";

export interface Root {
    id: string
    dni: string
    nombre: string
    apellido: string
    direccion: string
    telefono: string
    llamadas: Llamada[]
}

export interface Llamada {
    id: string
    esBroma: boolean
    fechaHora: string
    comentario: string
    operadorId: string
    especialistaId: string
    pacienteId: string
    especialista: string
    operador: string
    paciente: string
    interacciones: Interaccione[]
}

export interface Interaccione {
    id: string
    fechaHora: string
    pregunta: string
    respuesta: string
    llamadaId: string
    llamada: []
}

interface SelectPacienteProps {
    handleChange: (event: React.ChangeEvent<HTMLSelectElement>) => void

}

function SelectPaciente({handleChange}: SelectPacienteProps) {
    const [pacientes, setPacientes] = useState([])
    const requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    const URL = 'http://localhost:8080/api/v1/pacientes'

    useEffect(() => {
        fetch(URL, requestOptions as RequestInit).then(response => {
            if (response.ok) {
                response.json().then((data) => {
                    setPacientes(data)
                })
            } else {
                throw new Error('Something went wrong')
            }

        })
    }, [])
    return (
        <>
            <label htmlFor="pacientes" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-800">Selecciona
                un paciente</label>
            <select id="pacientes"
                    onChange={handleChange}
                    className="py-3 px-4 pe-9 block w-full rounded-lg text-sm focus:border-blue-500 focus:ring-blue-500 disabled:opacity-50 disabled:pointer-events-none bg-blue-50 border-gray-800 text-black">
                <option value=""></option>
                {pacientes ? pacientes.map((paciente: Root) => (
                        <option key={paciente.id} value={paciente.id}>{paciente.nombre} {paciente.apellido}</option>
                    ))
                    : <option value="">No hay pacientes</option>}
            </select>


        </>
    );
}

export default SelectPaciente;