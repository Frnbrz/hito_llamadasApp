interface InputComentarioProps {
    handleChange: (event: React.ChangeEvent<HTMLInputElement>) => void
}

function InputComentario({handleChange}: InputComentarioProps) {
    return (
        <input
            type="text"
            placeholder="Comentario"
            className="rounded-md appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-purple-500 focus:border-purple-500 focus:z-10 sm:text-sm"
            name="comentario"
            id="comentario"
            required
            onChange={handleChange}
        />
    )
}

export default InputComentario
