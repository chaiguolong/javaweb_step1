syntax match Brackets display '[(){}\[\]]'
highlight link Brackets Special

syntax match ClassName display '\<\([A-Z][a-z0-9]*\)\+\>'
syntax match ClassName display '\.\@<=\*'
highlight link ClassName Identifier

syntax match Constructor display '\(\(public\|protected\|private\)\s\+\)\@<=\([A-Z][a-z0-9]*\)\+\( *(\)\@='
highlight link Constructor PreProc
