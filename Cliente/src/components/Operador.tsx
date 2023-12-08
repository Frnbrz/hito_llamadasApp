import {EsBroma, FormAction, FormError, InfoText, SeDeriba, SelectEspecialista, SelectPaciente} from "@/components";
import {operadorFiels} from "@/constants/operadorFiels";
import {useState} from "react";


const fields = operadorFiels
const fieldsState: Record<string, string> = {}
fields.forEach(field => (fieldsState[field.id] = ''))

interface LlamadaBody {
    operadorId: string
    pacienteId: string
    esBroma?: boolean
    especialistaId?: string
}

function Operador() {
    const [stepperState, setStepperState] = useState(0)
    const [selectPacienteState, setSelectPacienteState] = useState('')
    const [selectEspecialistaState, setSelectEspecialistaState] = useState('')
    const [esBroma, setEsBroma] = useState(false)
    const [seDeriba, setSeDeriba] = useState(false)


    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault()
        authenticateUser()
    }
    const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSelectPacienteState(event.target.value)
        setStepperState(1)
    }
    const handleChangeBroma = (event: React.ChangeEvent<HTMLSelectElement>) => {
        const value: boolean = event.target.value === '1' ? true : false
        setEsBroma(value)
        setStepperState(2)
    }
    const handleChangeDeriba = (event: React.ChangeEvent<HTMLSelectElement>) => {

        const value: boolean = event.target.value === '1' ? true : false

        setSeDeriba(value)
        setStepperState(3)
    }
    const handleChangeEspecialista = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSelectEspecialistaState(event.target.value)
        setStepperState(3)
    }
    const authenticateUser = () => {

        const URL = 'http://localhost:8080/api/v1/llamadas'

        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");


        const llamadaBody: LlamadaBody = {
            "operadorId": JSON.parse(localStorage.getItem('user')!).id,
            "pacienteId": selectPacienteState,
            esBroma: false,
            especialistaId: undefined
        }

        if (esBroma) {
            llamadaBody.esBroma = esBroma
        } else if (seDeriba && selectEspecialistaState !== '') {
            llamadaBody.especialistaId = selectEspecialistaState
        }


        const requestOptions: RequestInit = {
            method: 'POST',
            headers: myHeaders,
            body: JSON.stringify(llamadaBody),
            redirect: 'follow'
        };

        console.log(requestOptions)

        fetch(URL, requestOptions as RequestInit)
    }

    return (
        <form className='mt-12 space-y-6' onSubmit={handleSubmit} method='POST'>
            {stepperState >= 0 && <SelectPaciente handleChange={handleChange}/>}
            {stepperState >= 1 && <EsBroma handleChange={handleChangeBroma}/>}
            {stepperState >= 2 && !esBroma && <SeDeriba handleChange={handleChangeDeriba}/>}
            {seDeriba === true && !esBroma && <SelectEspecialista handleChange={handleChangeEspecialista}/>}
            {stepperState === 3 || esBroma && <InfoText text='puedes crear la llamada'/>}
            <FormError error={false} text='Invalid password'/>
            <FormAction text='Crear Llamada'/>
        </form>
    )
}

export default Operador
