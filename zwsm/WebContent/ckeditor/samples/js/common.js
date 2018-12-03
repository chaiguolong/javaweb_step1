/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * isInvalid(组件id,类型(string,date,number),最小长度,最大长度,是否可以为空,验证失败时alert 消息)
 * Sytree 2011-10-31
 */


function IsOK( _object, _type, _space, _msginfo, _minlen, _maxlen)
{
    var _invalid = false;
    
    if (_type == null) _type = 'string';
    if (_type == 'date')
    {
        if (_minlen != 8) _minlen = 10;
        _maxlen = _minlen;
    }
    else
    {
        if (_minlen == null) _minlen = 1;
        if (_maxlen == null && _minlen >= 0) _maxlen = 255;
    }
    if (_space==null) _space=false;
    if ((_space) && (_object.value=='')) return false;
    _object.value = trim(_object.value);
    if ( (_maxlen > 0 && _object.value.length > _maxlen) ||
        (_minlen > 0 && _object.value.length < _minlen) ||
        (_minlen < 0 && _object.value.length != Math.abs(_minlen) && _object.value.length != Math.abs(_maxlen)) ||
        (_minlen == 0 && _maxlen < 0 && _object.value.length > 0 && _object.value.length != Math.abs(_maxlen)) )
        {
        _invalid = true;
    }
    if (!_invalid)
    {
        if (_type == 'number')
            _invalid = isNaN(_object.value);
        else if (_type == 'date')
            _invalid = !isDate(_object.value);
    }
    if (_invalid && (_msginfo != null) && (_msginfo.length > 0))
    {
        alert(_msginfo);
        _object.select();
        _object.focus();
        return _invalid;
    }
    return _invalid;
}
function rightTrim(_text)
{
    var _last;

    _last = _text.length;
    while (_text.charAt(_last - 1) == " ") _last --;

    return _text.substring(0, _last);
}

function leftTrim(_text)
{
    var _first = 0;

    while (_text.charAt(_first) == " ") _first ++;

    return _text.substring(_first);
}

function trim(_text)
{
    if (_text == null) return null;
    _text = leftTrim(_text);
    _text = rightTrim(_text);
    return _text;
}

function replaceAll(_text, _src, _trg)
{
    var _pos;

    _text += '';
    _src += '';
    _trg += '';
    if (_src == _trg || _src == "") {
        return _text;
    }

    _pos = _text.indexOf(_src);
    while (_pos >= 0)
    {
        if (_text.length <= _pos + _src.length)
            _text = _text.substring(0, _pos) + _trg;
        else
            _text = _text.substring(0, _pos) + _trg + _text.substring(_pos + _src.length);

        _pos = _text.indexOf(_src, _pos + _trg.length);
    }
    return _text;
}