import {FormAction, FormError, InfoText, InputComentario, SelectLlamada} from "@/components";
import {operadorFiels} from "@/constants/operadorFiels";
import {useState} from "react";


const fields = operadorFiels
const fieldsState: Record<string, string> = {}
fields.forEach(field => (fieldsState[field.id] = ''))

interface LlamadaBody {
    comentario: string
}

function Especialista() {
    const [stepperState, setStepperState] = useState(0)
    const [llamada, setLlamada] = useState('')
    const [comentario, setComentario] = useState('')
    const [update, setUpdate] = useState(false)


    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault()
        authenticateUser()
    }
    const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setLlamada(event.target.value)
        setStepperState(1)
    }
    const handleChangeComentario = (event: React.ChangeEvent<HTMLInputElement>) => {
        setComentario(event.target.value)
        setStepperState(2)
    }


    const authenticateUser = () => {

        const URL = 'http://localhost:8080/api/v1/llamadas'
        const URL_FINAL = URL + '/' + llamada

        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");


        const llamadaBody: LlamadaBody = {
            "comentario": comentario,
        }


        const requestOptions: RequestInit = {
            method: 'PUT',
            headers: myHeaders,
            body: JSON.stringify(llamadaBody),
            redirect: 'follow'
        };

        console.log(requestOptions)

        fetch(URL_FINAL, requestOptions as RequestInit).then(
            response => {
                if (response.ok) {

                    setUpdate(!update)

                } else {
                    throw new Error('Something went wrong')
                }
            }
        ).catch(error => console.log('error', error));
    }

    return (
        <form className='mt-12 space-y-6' onSubmit={handleSubmit} method='POST'>
            {stepperState >= 0 && <SelectLlamada handleChange={handleChange} update={update}/>}
            {stepperState >= 1 && <InputComentario handleChange={handleChangeComentario}/>}
            {stepperState === 2 && <InfoText text='Puedes añadir tu comentario'/>}
            <FormError error={false} text='Invalid password'/>
            <FormAction text='Crear Llamada'/>
        </form>
    )
}

export default Especialista
