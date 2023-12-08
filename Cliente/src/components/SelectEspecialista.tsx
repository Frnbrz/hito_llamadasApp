import {useEffect, useState} from "react";

export type Root = Root2[]

export interface Root2 {
    id: string
    nombre: string
    apellido: string
    email: string
    direccion: string
    turno: string
    categoria: string
    llamadas: Llamada[]
}

export interface Llamada {
    id: string
    esBroma: boolean
    fechaHora: string
    comentario?: string
    operadorId: string
    especialistaId: string
    pacienteId: string
    especialista: Root2
    operador: any
    paciente: any
    interacciones: Interaccione[]
}

export interface Interaccione {
    id: string
    fechaHora: string
    pregunta: string
    respuesta: string
    llamadaId: string
    llamada: any
}


function SelectEspecialista({handleChange}: { handleChange: (event: React.ChangeEvent<HTMLSelectElement>) => void }) {

    const [especialistas, setEspecialistas] = useState([] as Root)

    const requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    const URL = 'http://localhost:8080/api/v1/especialistas'

    useEffect(() => {
        fetch(URL, requestOptions as RequestInit).then(response => {
            if (response.ok) {
                response.json().then((data) => {
                    setEspecialistas(data)
                })
            } else {
                throw new Error('Something went wrong')
            }

        })
    }, [])

    return (
        <>
            <label htmlFor="deriba" className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-800">Deribacion
                Especialista</label>
            <select onChange={handleChange} id="deriba"
                    className="py-3 px-4 pe-9 block w-full rounded-lg text-sm focus:border-blue-500 focus:ring-blue-500 disabled:opacity-50 disabled:pointer-events-none bg-blue-50 border-gray-800 text-black">
                <option value=""></option>
                {especialistas ? especialistas.map((especialista: Root2) => (
                        <option key={especialista.id}
                                value={especialista.id}>{especialista.nombre} {especialista.apellido}</option>
                    ))
                    :
                    <option value="">No hay especialistas</option>
                }

            </select>
        </>
    );
}

export default SelectEspecialista;